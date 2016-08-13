package com.longlydeer.deer.common.web.captcha;

import com.jhlabs.image.WaterFilter;
import com.longlydeer.deer.common.Constants;
import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.LineTextDecorator;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.awt.image.ImageFilter;

/**
 * 类的buildInitialFactories()这个方法可以定制一些属性,
 * 如生产的验证码要不要包含某些字符,背景图,验证码字体样式
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public class CustomListImageCaptchaEngine extends ListImageCaptchaEngine {

    @Override
    protected void buildInitialFactories() {
        // build filters
        WaterFilter water = new WaterFilter();

        water.setAmplitude(3d);
        water.setAntialias(true);
        water.setPhase(20d);
        water.setWavelength(70d);

        ImageDeformation backDef = new ImageDeformationByFilters(
                new ImageFilter[] {});
        ImageDeformation textDef = new ImageDeformationByFilters(
                new ImageFilter[] {});
        ImageDeformation postDef = new ImageDeformationByFilters(
                new ImageFilter[] { water });

        // word generator
        WordGenerator dictionnaryWords = new RandomWordGenerator(
                "abcdefhjkmnprstuvwxyz23456789");
        // wordtoimage components
        RandomRangeColorGenerator colors = new RandomRangeColorGenerator(
                new int[] { 0, 150 }, new int[] { 0, 150 },
                new int[] { 0, 150 });

        // Arial,Tahoma,Verdana,Helvetica,宋体,黑体,幼圆
        Font[] fonts = new Font[] { new Font("Arial", 0, 15),
                new Font("Tahoma", 0, 15), new Font("Verdana", 0, 15),
                new Font("Helvetica", 0, 15), new Font("宋体", 0, 15),
                new Font("黑体", 0, 15), new Font("幼圆", 0, 15) };

        // 设置字符以及干扰线
        RandomRangeColorGenerator lineColors = new RandomRangeColorGenerator(
                new int[] { 150, 255 }, new int[] { 150, 255 }, new int[] {
                150, 255 });

        TextPaster randomPaster = new DecoratedRandomTextPaster(new Integer(4),
                new Integer(4), colors, true,
                new TextDecorator[] { new LineTextDecorator(new Integer(1),
                        lineColors) });
        BackgroundGenerator back = new UniColorBackgroundGenerator(new Integer(
                140), new Integer(45), Color.white);

        FontGenerator shearedFont = new RandomFontGenerator(new Integer(30),
                new Integer(0), fonts);
        // word2image 1
        WordToImage word2image;
        word2image = new DeformedComposedWordToImage(shearedFont, back,
                randomPaster, backDef, textDef, postDef);

        this.addFactory(new GimpyFactory(dictionnaryWords, word2image));
    }


/*    private static final int minFontSize = 12;
    private static final int maxFontSize = 16;
    private static final int minAcceptedWordLength = 4;
    private static final int maxAcceptedWordLength = 4;
    private static final String acceptedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CAPTCHAPATH = Constants.FILE_SEPRATOR + "captcha" + Constants.FILE_SEPRATOR;
    private static final Font[] fontsList = {new Font("nyala", 1, 16),
            new Font("Arial", 1, 16), new Font("nyala", 1, 16),
            new Font("Bell", 1, 16), new Font("Bell MT", 1, 16),
            new Font("Credit", 1, 16), new Font("valley", 1, 16),
            new Font("Impact", 1, 16)};
    private static final Color[] colorList = {new Color(255, 255, 255),
            new Color(255, 220, 220), new Color(220, 255, 255),
            new Color(220, 220, 255), new Color(255, 255, 220),
            new Color(220, 255, 220)};

    @Override
    protected void buildInitialFactories() {
        RandomFontGenerator randomFontGenerator = new RandomFontGenerator(
                Integer.valueOf(12),
                Integer.valueOf(16),
                fontsList);

        FileReaderRandomBackgroundGenerator fileReaderRandomBackgroundGenerator = new FileReaderRandomBackgroundGenerator(
                Integer.valueOf(80),
                Integer.valueOf(28),
                new ClassPathResource(CAPTCHAPATH).getPath());

        DecoratedRandomTextPaster decoratedRandomTextPaster = new DecoratedRandomTextPaster(
                Integer.valueOf(4), Integer.valueOf(4),
                new RandomListColorGenerator(colorList), new TextDecorator[0]);
        addFactory(new GimpyFactory(new RandomWordGenerator(acceptedChars),
                new ComposedWordToImage(randomFontGenerator,
                        fileReaderRandomBackgroundGenerator,
                        decoratedRandomTextPaster)));
    }*/
}
