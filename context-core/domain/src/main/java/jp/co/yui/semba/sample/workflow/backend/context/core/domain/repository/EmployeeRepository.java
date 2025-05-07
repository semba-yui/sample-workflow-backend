/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Employee;

/**
 * 従業員リポジトリ
 *
 * <p>従業員に関する永続化処理を行うインターフェース
 */
public interface EmployeeRepository {

  /**
   * 従業員IDから従業員を取得する
   *
   * @param empId 従業員ID
   * @return 従業員
   */
  Optional<Employee> findById(Long empId);

  /**
   * 社員番号から従業員を取得する
   *
   * @param empCode 社員番号
   * @return 従業員
   */
  Optional<Employee> findByCode(String empCode);

  /**
   * メールアドレスから従業員を取得する
   *
   * @param email メールアドレス
   * @return 従業員
   */
  Optional<Employee> findByEmail(String email);

  /**
   * 会社IDに紐づく従業員を取得する
   *
   * @param companyId 会社ID
   * @return 従業員のリスト
   */
  List<Employee> findByCompanyId(Long companyId);

  /**
   * 組織IDに紐づく従業員を取得する
   *
   * @param orgId 組織ID
   * @return 従業員のリスト
   */
  List<Employee> findByOrgId(Long orgId);

  /**
   * 指定時点で有効な従業員を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な従業員のリスト
   */
  List<Employee> findActiveAt(LocalDateTime timestamp);

  /**
   * 従業員を保存する
   *
   * @param employee 保存対象の従業員
   * @return 保存された従業員
   */
  Employee save(Employee employee);

  /**
   * 従業員を論理削除する
   *
   * @param employee 削除対象の従業員
   * @param at 削除日時
   * @return 削除された従業員
   */
  default Employee softDelete(Employee employee, LocalDateTime at) {
    return save(employee.withDeletedAt(at));
  }
}
