/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.RolePermission;

/**
 * ロールパーミッションリポジトリ
 *
 * <p>ロールとパーミッションの関連に関する永続化処理を行うインターフェース
 */
public interface RolePermissionRepository {

  /**
   * ロールIDとパーミッションIDからロールパーミッション関連を取得する
   *
   * @param roleId ロールID
   * @param permId パーミッションID
   * @return ロールパーミッション関連
   */
  Optional<RolePermission> findByRoleIdAndPermId(Long roleId, Long permId);

  /**
   * ロールIDに紐づくすべてのロールパーミッション関連を取得する
   *
   * @param roleId ロールID
   * @return ロールパーミッション関連のリスト
   */
  List<RolePermission> findByRoleId(Long roleId);

  /**
   * パーミッションIDに紐づくすべてのロールパーミッション関連を取得する
   *
   * @param permId パーミッションID
   * @return ロールパーミッション関連のリスト
   */
  List<RolePermission> findByPermId(Long permId);

  /**
   * 指定時点で有効なロールパーミッション関連を取得する
   *
   * @param timestamp 検索日時
   * @return 有効なロールパーミッション関連のリスト
   */
  List<RolePermission> findActiveAt(LocalDateTime timestamp);

  /**
   * ロールパーミッション関連を保存する
   *
   * @param rolePermission 保存対象のロールパーミッション関連
   * @return 保存されたロールパーミッション関連
   */
  RolePermission save(RolePermission rolePermission);

  /**
   * ロールパーミッション関連を論理削除する
   *
   * @param rolePermission 削除対象のロールパーミッション関連
   * @param at 削除日時
   * @return 削除されたロールパーミッション関連
   */
  default RolePermission softDelete(RolePermission rolePermission, LocalDateTime at) {
    return save(rolePermission.withDeletedAt(at));
  }
}
