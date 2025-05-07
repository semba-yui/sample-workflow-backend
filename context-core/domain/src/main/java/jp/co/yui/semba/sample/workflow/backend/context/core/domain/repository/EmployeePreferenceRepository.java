/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.EmployeePreference;

/**
 * 従業員個人設定リポジトリ
 *
 * <p>従業員個人設定に関する永続化処理を行うインターフェース
 */
public interface EmployeePreferenceRepository {

  /**
   * 従業員IDから個人設定を取得する
   *
   * @param empId 従業員ID
   * @return 従業員個人設定
   */
  Optional<EmployeePreference> findById(Long empId);

  /**
   * 指定時点で有効な従業員個人設定を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な従業員個人設定のリスト
   */
  List<EmployeePreference> findActiveAt(LocalDateTime timestamp);

  /**
   * 従業員個人設定を保存する
   *
   * @param employeePreference 保存対象の従業員個人設定
   * @return 保存された従業員個人設定
   */
  EmployeePreference save(EmployeePreference employeePreference);

  /**
   * 従業員個人設定を論理削除する
   *
   * @param employeePreference 削除対象の従業員個人設定
   * @param at 削除日時
   * @return 削除された従業員個人設定
   */
  default EmployeePreference softDelete(EmployeePreference employeePreference, LocalDateTime at) {
    return save(employeePreference.withDeletedAt(at));
  }
}
