package sra.param.vo;

import java.text.DecimalFormat;

import com.cmbc.edw.dao.AbstractPrimaryKey;

public class CodeItemKey extends AbstractPrimaryKey {

  private static String table = "T_SYS_CODE_ITEM";
  private static String pk = "CAT_CODE";
  private static String format = "0000000000";
  private static int offset = 0;

  private static CodeItemKey instance = null;

  public static CodeItemKey getInstance() {
    if (instance == null) {
      instance = new CodeItemKey();
      instance.setWithoutKey(true);
    }
    return instance;
  }

  protected String buildMaxSql() {
    return "select max(" + pk + ") as CURRENT_VALUE FROM " + table;
  }

  protected String firstValue(String key) {
    return format;
  }

  protected void valueAdd(String org) {
    currentValue = new DecimalFormat(format).format(Integer.parseInt(currentValue.substring(offset)) + 1);
  }

}