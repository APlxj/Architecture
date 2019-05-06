package swallow.com.model_utils;

import android.widget.EditText;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class EditUtils {

    public static void requestFocus(EditText editText) {
        editText.requestFocus();
        editText.setFocusable(true);
        editText.selectAll();
    }
}
