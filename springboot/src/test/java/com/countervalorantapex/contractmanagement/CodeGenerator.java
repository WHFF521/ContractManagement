package com.countervalorantapex.contractmanagement;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/contract_management?useSSL=false";
        String username="root";
        String password = "260815";
        String mapperModle="sys";
        String mapperLocation="E:\\JavaPracticeProject\\springboot02\\src\\main\\resources\\mapper\\"+mapperModle;
        String tables="contract_info,contract_payment,contract_types,contract_types_info,contracts,customers,invoice_info,payment_types,projects,users,weekly_reports";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("lca") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\JavaPracticeProject\\springboot02\\src\\main\\java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent("com.countervalorantapex.contractmanagement") // 设置父包名
                            .moduleName(mapperModle) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
