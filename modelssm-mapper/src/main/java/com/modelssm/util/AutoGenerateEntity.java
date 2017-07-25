package com.modelssm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.modelssm.constant.AutoGenerateConstant;

/**
 * @author zxy
 * 自动生成实体
 * 自动生成mapping
 */
public class AutoGenerateEntity {

	public static void main(String[] args) {
		
		List<String> warnings=new ArrayList<String>();
		//通过文件查询配置的文件，把文件解析成资源Configuration
		File file=new File(Class.class.getClass().getResource("/").getPath().concat(AutoGenerateConstant.AUTO_GENERATE_XML));
		//生成资源解析器 成String 
		ConfigurationParser cp=new ConfigurationParser(warnings);
		try {
			//获取Configuration
			Configuration c=cp.parseConfiguration(file);
			//生成ShellCallback
			DefaultShellCallback sc=new DefaultShellCallback(true);
			//Configuration configuration,  自动生成需要的三参数
			//ShellCallback shellCallback, 
			//List<String> warnings
			MyBatisGenerator myBatisGenerator=new MyBatisGenerator(c, sc, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("自动生成成功！");
	}

}
