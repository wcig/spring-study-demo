package com.wcig.app.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Java model,mapper类格式化插件
 */
public class JavaModelFormatterPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * model类使用lombok注解
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 添加lombok引入
        topLevelClass.addImportedType("lombok.experimental.Accessors");
        topLevelClass.addImportedType("lombok.Data");

        // 添加lombok注解
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@Accessors(chain = true)");

        // 添加注释
        String tableName = introspectedTable.getFullyQualifiedTable().toString();
        String tableComment = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(String.format(" * %s (%s)", tableName, tableComment));
        topLevelClass.addJavaDocLine(" */");
        return true;
    }

    /**
     * model类不生成get方法
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * model类不生成set方法
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * model类属性添加注释 (列名 + 索引 + 最大长度 + 注释)
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String columnName = introspectedColumn.getActualColumnName();
        String columnComment = introspectedColumn.getRemarks();
        int columnLength = introspectedColumn.getLength();
        boolean isNull = introspectedColumn.isNullable();
        boolean isPk = false;
        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        if (primaryKeyColumns.size() > 0) {
            List<String> primaryKeyColumnNames = primaryKeyColumns.stream().map(IntrospectedColumn::getActualColumnName).collect(Collectors.toList());
            isPk = primaryKeyColumnNames.contains(columnName);
        }
        field.addAnnotation(String.format("// column:%s, pk:%s, maxLength:%d, isNull:%b, comment:%s", columnName, isPk, columnLength, isNull, columnComment));
        return true;
    }

    // /**
    //  * mapper类继承mybatisplus父接口
    //  */
    // @Override
    // public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    //     FullyQualifiedJavaType superInterfaceType = new FullyQualifiedJavaType("BaseMapper<" + introspectedTable.getBaseRecordType() + ">");
    //     FullyQualifiedJavaType superImportType = new FullyQualifiedJavaType("com.baomidou.mybatisplus.core.mapper.BaseMapper");
    //     interfaze.addSuperInterface(superInterfaceType);
    //     interfaze.addImportedType(superImportType);
    //     return true;
    // }
}
