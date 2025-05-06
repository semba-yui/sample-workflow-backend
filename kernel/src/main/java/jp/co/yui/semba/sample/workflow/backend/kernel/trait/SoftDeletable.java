/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.kernel.trait;

import java.time.LocalDateTime;
import java.util.Optional;

/** 論理削除可能を表すマーカーインターフェース */
public interface SoftDeletable {

  /**
   * 削除日時（未削除なら null）
   *
   * @return 削除日時
   */
  Optional<LocalDateTime> getDeletedAt();

  /**
   * 論理削除されているかどうかを判定する
   *
   * @return true: 既に削除済み / false: 削除されていない
   */
  default boolean isDeleted() {
    return getDeletedAt().isEmpty();
  }
}
