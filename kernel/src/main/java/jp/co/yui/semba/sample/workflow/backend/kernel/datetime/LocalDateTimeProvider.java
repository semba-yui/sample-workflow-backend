/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.kernel.datetime;

import java.time.LocalDateTime;

/**
 * LocalDateTimeを取得するためのインターフェース
 *
 * <p>LocalDateTime.now()をラップすることで、テスト時にモック化しやすくするためのインターフェース
 */
@FunctionalInterface
public interface LocalDateTimeProvider {

  /**
   * 現在の日時を取得する
   *
   * @return 現在の日時
   */
  LocalDateTime now();
}
