package org.apache.poi.xwpf.converter.styles.run;

import org.apache.poi.xwpf.converter.internal.XWPFUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

public class RunFontStyleItalicValueProvider
    extends AbstractRunValueProvider<Boolean>
{

    public static RunFontStyleItalicValueProvider INSTANCE = new RunFontStyleItalicValueProvider();

    @Override
    public Boolean getValue( CTRPr rpr )
    {
        return isItalic( rpr );
    }

    private static Boolean isItalic( CTRPr pr )
    {
        if ( pr == null || !pr.isSetI() )
        {
            return null;
        }
        return XWPFUtils.isCTOnOff( pr.getI() );
    }

}
