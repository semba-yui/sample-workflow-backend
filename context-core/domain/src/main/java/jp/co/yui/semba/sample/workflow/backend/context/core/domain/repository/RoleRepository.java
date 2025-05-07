/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Role;

/**
 * ロールリポジトリ
 *
 * <p>ロールに関する永続化処理を行うインターフェース
 */
public interface RoleRepository {

  /**
   * ロールIDからロールを取得する
   *
   * @param roleId ロールID
   * @return ロール
   */
  Optional<Role> findById(Long roleId);

  /**
   * ロールコードからロールを取得する
   *
   * @param roleCode ロールコード
   * @return ロール
   */
  Optional<Role> findByCode(String roleCode);

  /**
   * 会社IDに紐づくロールを取得する
   *
   * @param companyId 会社ID
   * @return ロールのリスト
   */
  List<Role> findByCompanyId(Long companyId);

  /**
   * 指定時点で有効なロールを取得する
   *
   * @param timestamp 検索日時
   * @return 有効なロールのリスト
   */
  List<Role> findActiveAt(LocalDateTime timestamp);

  /**
   * 会社IDと指定時点で有効なロールを取得する
   *
   * @param companyId 会社ID
   * @param timestamp 検索日時
   * @return 有効なロールのリスト
   */
  List<Role> findByCompanyIdAndActiveAt(Long companyId, LocalDateTime timestamp);

  /**
   * ロールを保存する
   *
   * @param role 保存対象のロール
   * @return 保存されたロール
   */
  Role save(Role role);

  /**
   * ロールを論理削除する
   *
   * @param role 削除対象のロール
   * @param at 削除日時
   * @return 削除されたロール
   */
  default Role softDelete(Role role, LocalDateTime at) {
    return save(role.withDeletedAt(at));
  }
}
