/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.EmployeeDelegate;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.DelegateMode;

/**
 * 代理設定リポジトリ
 *
 * <p>従業員の代理設定に関する永続化処理を行うインターフェース
 */
public interface EmployeeDelegateRepository {

  /**
   * 代理シーケンスから代理設定を取得する
   *
   * @param delegateSeq 代理シーケンスPK
   * @return 代理設定
   */
  Optional<EmployeeDelegate> findById(Long delegateSeq);

  /**
   * 本人IDから代理設定を取得する
   *
   * @param empId 本人ID
   * @return 代理設定のリスト
   */
  List<EmployeeDelegate> findByEmpId(Long empId);

  /**
   * 代理人IDから代理設定を取得する
   *
   * @param delegateId 代理人ID
   * @return 代理設定のリスト
   */
  List<EmployeeDelegate> findByDelegateId(Long delegateId);

  /**
   * 指定時点で有効な代理設定を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な代理設定のリスト
   */
  List<EmployeeDelegate> findActiveAt(LocalDateTime timestamp);

  /**
   * 本人IDと指定時点で有効な代理設定を取得する
   *
   * @param empId 本人ID
   * @param timestamp 検索日時
   * @return 有効な代理設定のリスト
   */
  List<EmployeeDelegate> findByEmpIdAndActiveAt(Long empId, LocalDateTime timestamp);

  /**
   * 代理人IDと指定時点で有効な代理設定を取得する
   *
   * @param delegateId 代理人ID
   * @param timestamp 検索日時
   * @return 有効な代理設定のリスト
   */
  List<EmployeeDelegate> findByDelegateIdAndActiveAt(Long delegateId, LocalDateTime timestamp);

  /**
   * 代理モードと指定時点で有効な代理設定を取得する
   *
   * @param mode 代理モード
   * @param timestamp 検索日時
   * @return 有効な代理設定のリスト
   */
  List<EmployeeDelegate> findByModeAndActiveAt(DelegateMode mode, LocalDateTime timestamp);

  /**
   * 代理設定を保存する
   *
   * @param employeeDelegate 保存対象の代理設定
   * @return 保存された代理設定
   */
  EmployeeDelegate save(EmployeeDelegate employeeDelegate);

  /**
   * 代理設定を論理削除する
   *
   * @param employeeDelegate 削除対象の代理設定
   * @param at 削除日時
   * @return 削除された代理設定
   */
  default EmployeeDelegate softDelete(EmployeeDelegate employeeDelegate, LocalDateTime at) {
    return save(employeeDelegate.withDeletedAt(at));
  }
}
