/**
 * Copyright (C) 2011 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.opensagres.xdocreport.converter.docx.poi.itext;

import org.apache.poi.xwpf.converter.itext.PDFViaITextOptions;
import org.junit.Assert;
import org.junit.Test;

import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.converter.OptionsHelper;

public class PDFViaITextOptionsTestCase
{

    @Test
    public void testNullOptions()
        throws Exception
    {
        Options options = null;
        PDFViaITextOptions pdfOptions = XWPF2PDFViaITextConverter.getInstance().toPDFViaITextOptions( options );
        Assert.assertNull( pdfOptions );
    }

    @Test
    public void testNotNullOptions()
        throws Exception
    {
        Options options = Options.getFrom( "DOCX" );
        PDFViaITextOptions pdfOptions = XWPF2PDFViaITextConverter.getInstance().toPDFViaITextOptions( options );
        Assert.assertNotNull( pdfOptions );
    }

    @Test
    public void testOptionsWithFontEncoding()
        throws Exception
    {
        Options options = Options.getFrom( "DOCX" );
        OptionsHelper.setFontEncoding( options, "UTF-8" );
        PDFViaITextOptions pdfOptions = XWPF2PDFViaITextConverter.getInstance().toPDFViaITextOptions( options );
        Assert.assertNotNull( pdfOptions );
        Assert.assertEquals( "UTF-8", pdfOptions.getFontEncoding() );
    }

    @Test
    public void testWithSubOptions()
        throws Exception
    {
        PDFViaITextOptions pdfOptions1 = PDFViaITextOptions.create();
        Options options = Options.getFrom( "DOCX" ).subOptions( pdfOptions1 );
        PDFViaITextOptions pdfOptions2 = XWPF2PDFViaITextConverter.getInstance().toPDFViaITextOptions( options );
        Assert.assertNotNull( pdfOptions2 );
        Assert.assertEquals( pdfOptions1, pdfOptions2 );
    }
}
