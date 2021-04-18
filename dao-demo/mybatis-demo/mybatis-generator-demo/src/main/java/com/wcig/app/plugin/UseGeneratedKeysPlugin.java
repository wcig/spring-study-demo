package com.wcig.app.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 当表主键只有一个字段且是自增主键时，为mapper.xml文件的insert、insertSelect方法配置添加以下3个属性来自动获取主键值：
 * keyColumn="xxx"
 * keyProperty="xxx"
 * useGeneratedKeys="true"
 */
public class UseGeneratedKeysPlugin extends PluginAdapter {

    private static final String USE_GENERATED_KEYS = "useGeneratedKeys";
    private static final String USE_GENERATED_KEYS_VALUE = "true";
    private static final String KEY_COLUMN = "keyColumn";
    private static final String KEY_PROPERTY = "keyProperty";

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        addUseGeneratedKeysAttributes(element, introspectedTable);
        return true;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        addUseGeneratedKeysAttributes(element, introspectedTable);
        return true;
    }

    /**
     * insert方法添加useGeneratedKeys相关属性
     */
    public void addUseGeneratedKeysAttributes(XmlElement element, IntrospectedTable introspectedTable) {
        boolean addedGeneratedKey = introspectedTable.getGeneratedKey() != null;
        // 必须table没有配置子元素generatedKey
        if (!addedGeneratedKey) {
            // 获取主键字段信息
            List<IntrospectedColumn> keyColumns = introspectedTable.getPrimaryKeyColumns();
            // 主键必须是一个字段
            if (keyColumns.size() == 1) {
                IntrospectedColumn keyColumn = keyColumns.get(0);
                // 主键必须是自增
                if (keyColumn.isAutoIncrement()) {
                    FullyQualifiedJavaType javaType = keyColumn.getFullyQualifiedJavaType();
                    // 主键映射的java类型必须是Integer或Long类型
                    if (javaType.equals(PrimitiveTypeWrapper.getIntegerInstance())
                            || javaType.equals(PrimitiveTypeWrapper.getLongInstance())) {
                        element.addAttribute(new Attribute(USE_GENERATED_KEYS, USE_GENERATED_KEYS_VALUE));
                        element.addAttribute(new Attribute(KEY_COLUMN, keyColumn.getActualColumnName()));
                        element.addAttribute(new Attribute(KEY_PROPERTY, keyColumn.getJavaProperty()));
                    }
                }
            }
        }
    }
}
