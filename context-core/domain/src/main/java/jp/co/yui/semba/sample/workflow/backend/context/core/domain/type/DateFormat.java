/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.type;

/** 日付フォーマット */
public enum DateFormat {
  /** 年/月/日 */
  YYYY_MM_DD("YYYY/MM/DD"),

  /** 日/月/年 */
  DD_MM_YYYY("DD/MM/YYYY"),

  /** 月/日/年 */
  MM_DD_YYYY("MM/DD/YYYY");

  private final String format;

  DateFormat(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
