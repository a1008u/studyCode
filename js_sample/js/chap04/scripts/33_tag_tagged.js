function escapeHtml(str) {
  if (!str) { return ''; }
  str = str.replace(/&/g, '&amp;');
  str = str.replace(/</g, '&lt;');
  str = str.replace(/>/g, '&gt;');
  str = str.replace(/"/g, '&quot;');
  str = str.replace(/'/g, '&#39;');
  return str;
}

function e(templates, ...values) {
  let result = '';
  for (let i = 0, len = templates.length; i < len; i++) {
    result += templates[i] + escapeHtml(values[i]);
  }
  return result;
}

/**
 * ・引数として「テンプレート文字列（分解したもの）」「埋め込む変数（可変長引数）」を受け取ること
 * ・戻り値として加工済みの文字列を返すこと
 */
let name = '<"Mario" & \'Luigi\'>';
console.log(e`こんにちは、${name}さん！`);