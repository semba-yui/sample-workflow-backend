/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.EmployeeDelegateScope;

/**
 * 代理範囲リポジトリ
 *
 * <p>代理範囲に関する永続化処理を行うインターフェース
 */
public interface EmployeeDelegateScopeRepository {

  /**
   * 代理範囲IDから代理範囲を取得する
   *
   * @param scopeId 代理範囲ID
   * @return 代理範囲
   */
  Optional<EmployeeDelegateScope> findById(Long scopeId);

  /**
   * 代理設定IDから代理範囲を取得する
   *
   * @param delegateSeq 代理設定ID
   * @return 代理範囲のリスト
   */
  List<EmployeeDelegateScope> findByDelegateSeq(Long delegateSeq);

  /**
   * 指定時点で有効な代理範囲を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な代理範囲のリスト
   */
  List<EmployeeDelegateScope> findActiveAt(LocalDateTime timestamp);

  /**
   * 代理設定IDと指定時点で有効な代理範囲を取得する
   *
   * @param delegateSeq 代理設定ID
   * @param timestamp 検索日時
   * @return 有効な代理範囲のリスト
   */
  List<EmployeeDelegateScope> findByDelegateSeqAndActiveAt(
      Long delegateSeq, LocalDateTime timestamp);

  /**
   * 代理範囲を保存する
   *
   * @param employeeDelegateScope 保存対象の代理範囲
   * @return 保存された代理範囲
   */
  EmployeeDelegateScope save(EmployeeDelegateScope employeeDelegateScope);

  /**
   * 代理範囲を論理削除する
   *
   * @param employeeDelegateScope 削除対象の代理範囲
   * @param at 削除日時
   * @return 削除された代理範囲
   */
  default EmployeeDelegateScope softDelete(
      EmployeeDelegateScope employeeDelegateScope, LocalDateTime at) {
    return save(employeeDelegateScope.withDeletedAt(at));
  }
}
