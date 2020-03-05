package hebaja.com.example.hebajaviagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import hebaja.com.example.hebajaviagens.models.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }

}
