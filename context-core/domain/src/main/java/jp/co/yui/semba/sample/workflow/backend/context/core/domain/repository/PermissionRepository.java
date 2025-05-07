/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Permission;

/**
 * パーミッションリポジトリ
 *
 * <p>パーミッションに関する永続化処理を行うインターフェース
 */
public interface PermissionRepository {

  /**
   * パーミッションIDからパーミッションを取得する
   *
   * @param permId パーミッションID
   * @return パーミッション
   */
  Optional<Permission> findById(Long permId);

  /**
   * 権限コードからパーミッションを取得する
   *
   * @param permCode 権限コード
   * @return パーミッション
   */
  Optional<Permission> findByCode(String permCode);

  /**
   * 指定時点で有効なパーミッションを取得する
   *
   * @param timestamp 検索日時
   * @return 有効なパーミッションのリスト
   */
  List<Permission> findActiveAt(LocalDateTime timestamp);

  /**
   * 会社IDに基づいてパーミッションを検索する
   *
   * @param companyId 会社ID
   * @return 会社に紐づくパーミッションのリスト
   */
  List<Permission> findByCompanyId(Long companyId);

  /**
   * 全社共通のパーミッションを取得する（companyId = null）
   *
   * @return 全社共通のパーミッションのリスト
   */
  List<Permission> findGlobalPermissions();

  /**
   * パーミッションを保存する
   *
   * @param permission 保存対象のパーミッション
   * @return 保存されたパーミッション
   */
  Permission save(Permission permission);

  /**
   * パーミッションを論理削除する
   *
   * @param permission 削除対象のパーミッション
   * @param at 削除日時
   * @return 削除されたパーミッション
   */
  default Permission softDelete(Permission permission, LocalDateTime at) {
    return save(permission.withDeletedAt(at));
  }
}
