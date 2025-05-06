/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo;

import org.springframework.lang.NonNull;

/**
 * 郵便番号
 *
 * <p>日本の郵便番号を表す値オブジェクトです。
 *
 * <p>形式は「123-4567」です。
 *
 * @param value 郵便番号
 */
public record PostalCode(@NonNull String value) {

  /**
   * コンストラクタ
   *
   * @param value 郵便番号
   */
  public PostalCode {
    if (!value.matches("\\d{3}-?\\d{4}")) {
      throw new IllegalArgumentException("invalid JP postal code: " + value);
    }
  }
}
