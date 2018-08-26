'use strict';

var _templateObject = _taggedTemplateLiteral(['こんにちは、', 'さん！'], ['こんにちは、', 'さん！']);

function _taggedTemplateLiteral(strings, raw) { return Object.freeze(Object.defineProperties(strings, { raw: { value: Object.freeze(raw) } })); }

function escapeHtml(str) {
  if (!str) {
    return '';
  }
  str = str.replace(/&/g, '&amp;');
  str = str.replace(/</g, '&lt;');
  str = str.replace(/>/g, '&gt;');
  str = str.replace(/"/g, '&quot;');
  str = str.replace(/'/g, '&#39;');
  return str;
}

function e(templates) {
  var result = '';

  for (var _len = arguments.length, values = Array(_len > 1 ? _len - 1 : 0), _key = 1; _key < _len; _key++) {
    values[_key - 1] = arguments[_key];
  }

  for (var i = 0, len = templates.length; i < len; i++) {
    result += templates[i] + escapeHtml(values[i]);
  }
  return result;
}

var name = '<"Mario" & \'Luigi\'>';
console.log(e(_templateObject, name));
