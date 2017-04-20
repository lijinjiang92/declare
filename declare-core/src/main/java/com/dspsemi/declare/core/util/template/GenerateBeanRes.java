package com.dspsemi.declare.core.util.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.asm.ClassReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.dspsemi.common.lang.Symbol;
import com.dspsemi.common.lang.dto.Entity;
import com.dspsemi.common.lang.reflect.ClassUtils;
import com.dspsemi.common.log.slf4j.Logger;
import com.dspsemi.common.log.slf4j.LoggerFactory;
import com.dspsemi.common.validate.Assert;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * @author XiaoJin Wang
 *
 */
public class GenerateBeanRes {
	
	private static final Logger LOG = LoggerFactory.getLogger(GenerateBeanRes.class);
	
	/**
	 * 要生成资源文件的Bean对象所在的路径
	 */
	private static final String[] basePackages = {
		"com/dspsemi/declare/core/pojo",
		"com/dspsemi/declare/core/bo"
	};
	
	private static final String 
			TEMPLATE = "bean_resource.ftl",
			OUTPUT_FILE = "src/main/java/com/dspsemi/declare/core/util/R.java";
	
	private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
	
	public static void main(String[] args) {
		generate();
	}
	
	/**
	 * 生成资源文件
	 */
	public static void generate() {
		Resource[] rs = new Resource[0];
		int lastIndex = rs.length;
		try {
			for(String basePackage : basePackages) {
				String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
						basePackage + "/" + DEFAULT_RESOURCE_PATTERN;
				Resource[] tmp = new PathMatchingResourcePatternResolver()
					.getResources(packageSearchPath);
				if(tmp.length > 0) {
					lastIndex = rs.length;
					rs = Arrays.copyOf(rs, rs.length + tmp.length);
					System.arraycopy(tmp, 0, rs, lastIndex, tmp.length);
				}
			}
			
		} catch (IOException e) {
			LOG.error("generate value-object resource error.", e);
		}
		
		Configuration cfg = new Configuration();
		Writer out = null;
		try {
			//方法1
			/*URL url = GenerateBeanRes.class.getResource("");
			File tlFile = new File(url.toURI());
			cfg.setDirectoryForTemplateLoading(tlFile);*/
			
			//方法2
			/*URL url = GenerateBeanRes.class.getResource("");
			cfg.setTemplateLoader(new FileTemplateLoader(new File(url.toURI())));*/
			
			//方法3
			cfg.setTemplateLoader(new ClassTemplateLoader(GenerateBeanRes.class, ""));
			
			//设置包装器，并将对象包装为数据模型
			Template tpl = cfg.getTemplate(TEMPLATE, "UTF-8");
			Map<String, BeanData[]> root = new LinkedHashMap<String, BeanData[]>();
			root.put("data", processRes2BeanData(rs));
			File outPutFile = new File(OUTPUT_FILE);
			if(!outPutFile.getParentFile().exists()) {
				outPutFile.getParentFile().mkdirs();
			}
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPutFile),"UTF-8"));
			if(LOG.isInfoEnabled()) {
				LOG.info("=== ********* Begin generate template *********** =====");
			}
			tpl.process(root, out);
			if(LOG.isInfoEnabled()) {
				LOG.info("=== ********* End generate template *********** =====");
			}
		} catch (IOException e) {
			LOG.error("generate value-object resource error.", e);
		} catch (TemplateException e) {
			LOG.error("generate value-object resource error.", e);
		}finally {
			IOUtils.closeQuietly(out);
		}
		
	}
	
	private static BeanData[] processRes2BeanData(Resource[] rs) {
		Assert.notEmpty(rs);
		BeanData[] beanData = new BeanData[rs.length];
		try {
			for(int i = 0; i < rs.length; i++) {
				Resource r = rs[i];
				if(r.isReadable()) {
					BeanData data = new BeanData();
					ClassReader cr = new ClassReader(r.getInputStream());
					String className = cr.getClassName();
					Class<?> clazz = ClassUtils.getClass(className
							.replace(Symbol.SLASH, Symbol.PERIOD));
					List<String> properties = new ArrayList<String>();
					data.setClazz(clazz.getName() + ".class");
					data.setClassName(clazz.getSimpleName());
					if(ClassUtils.isAssignable(clazz, Entity.class))
						data.setEntity(true);
					else
						data.setEntity(false);
					for(Class<?> curClazz = clazz; 
							curClazz != null && curClazz != Object.class; 
							curClazz = curClazz.getSuperclass()) {
						Field[] fields = curClazz.getDeclaredFields();
						for(Field f : fields) {
							if(Modifier.isFinal(f.getModifiers())
									|| Modifier.isStatic(f.getModifiers())) 
								continue;
							properties.add(f.getName());
						}
					}
					data.setProperties(properties);
					if(LOG.isInfoEnabled()) {
						LOG.info("==== Add {0} class to resources.", clazz);
					}
					beanData[i] = data;
				}
			}
		} catch (IOException e) {
			LOG.error("generate value-object resource error.", e);
		} catch (ClassNotFoundException e) {
			LOG.error("generate value-object resource error.", e);
		}
		return beanData;
	}
	
	public static class BeanData {
		
		private String clazz;
		private String className;
		private boolean entity;
		private List<String> properties;
		
		public String getClazz() {
			return clazz;
		}
		
		public void setClazz(String clazz) {
			this.clazz = clazz;
		}
		
		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public boolean isEntity() {
			return entity;
		}

		public void setEntity(boolean entity) {
			this.entity = entity;
		}

		public List<String> getProperties() {
			return properties;
		}
		
		public void setProperties(List<String> properties) {
			this.properties = properties;
		}
		
	}
	
}
