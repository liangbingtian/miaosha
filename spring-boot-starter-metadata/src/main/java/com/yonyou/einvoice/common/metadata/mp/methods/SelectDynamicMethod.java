package com.yonyou.einvoice.common.metadata.mp.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import java.util.Map;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 注入selectDynamic
 * @author liuqiangm
 */
public class SelectDynamicMethod extends AbstractMethod {
  @Override
  public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
    String sql = "<script>    select \n"
        + "    <if test=\"distinct != null and distinct\">\n"
        + "      distinct\n"
        + "    </if>\n"
        + "    <foreach collection=\"selectFields\" index=\"index\" item=\"item\" separator=\",\">\n"
        + "      t0.${item}\n"
        + "    </foreach>\n"
        + "    from ${tableName} t0\n"
        + "    ${conditionSql}</script>";
    SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, Map.class);
    return this.addSelectMappedStatementForTable(mapperClass, "selectByDynamicCondition", sqlSource, tableInfo);
  }
}
