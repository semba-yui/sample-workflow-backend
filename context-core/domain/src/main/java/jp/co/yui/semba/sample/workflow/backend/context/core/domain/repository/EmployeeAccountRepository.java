/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.EmployeeAccount;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.AccountPurpose;

/**
 * 従業員振込口座リポジトリ
 *
 * <p>従業員振込口座に関する永続化処理を行うインターフェース
 */
public interface EmployeeAccountRepository {

  /**
   * 口座IDから従業員振込口座を取得する
   *
   * @param accountId 口座ID
   * @return 従業員振込口座
   */
  Optional<EmployeeAccount> findById(Long accountId);

  /**
   * 従業員IDから従業員振込口座のリストを取得する
   *
   * @param empId 従業員ID
   * @return 従業員振込口座のリスト
   */
  List<EmployeeAccount> findByEmpId(Long empId);

  /**
   * 従業員IDと用途区分から従業員振込口座のリストを取得する
   *
   * @param empId 従業員ID
   * @param purpose 用途区分
   * @return 従業員振込口座のリスト
   */
  List<EmployeeAccount> findByEmpIdAndPurpose(Long empId, AccountPurpose purpose);

  /**
   * 指定時点で有効な従業員振込口座を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な従業員振込口座のリスト
   */
  List<EmployeeAccount> findActiveAt(LocalDateTime timestamp);

  /**
   * 従業員IDと指定時点で有効な従業員振込口座を取得する
   *
   * @param empId 従業員ID
   * @param timestamp 検索日時
   * @return 有効な従業員振込口座のリスト
   */
  List<EmployeeAccount> findByEmpIdAndActiveAt(Long empId, LocalDateTime timestamp);

  /**
   * 従業員振込口座を保存する
   *
   * @param employeeAccount 保存対象の従業員振込口座
   * @return 保存された従業員振込口座
   */
  EmployeeAccount save(EmployeeAccount employeeAccount);

  /**
   * 従業員振込口座を論理削除する
   *
   * @param employeeAccount 削除対象の従業員振込口座
   * @param at 削除日時
   * @return 削除された従業員振込口座
   */
  default EmployeeAccount softDelete(EmployeeAccount employeeAccount, LocalDateTime at) {
    return save(employeeAccount.withDeletedAt(at));
  }
}
