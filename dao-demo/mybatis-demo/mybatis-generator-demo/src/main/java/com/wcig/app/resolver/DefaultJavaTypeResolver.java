package com.wcig.app.resolver;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

public class DefaultJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    public DefaultJavaTypeResolver() {
        super();
        this.typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getTypeName())));
        this.typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT",
                new FullyQualifiedJavaType(Integer.class.getTypeName())));
    }
}
