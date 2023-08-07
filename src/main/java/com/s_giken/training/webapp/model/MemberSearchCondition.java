package com.s_giken.training.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // メンバー変数に対するゲッター・セッターを自動生成
@NoArgsConstructor // 引数のないコンストラクタを自動生成
@AllArgsConstructor // 全てのメンバ変数に対する引数を持つコンストラクタを自動生成
public class MemberSearchCondition {
    // メールアドレス検索用
    private String mail;

    // 氏名検索用メンバ変数を用意
    private String name;
}
