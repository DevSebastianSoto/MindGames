package com.devsmms.mindgames.ui.print;

import com.devsmms.mindgames.ui.enums.Color;

public class ColorPrinter {

    private final String START = "\u001b[";
    private final String RESET = "\u001b[0m";
    private final String END;

    private String bg_color;
    private String text_color;

    private ColorPrinter(boolean bright, Color bg_color, Color text_color) {
        this.END = (bright)?";1m":"m";
        this.bg_color = (bg_color != null)?START+bg_color.getBackGroundValue()+END:"";
        this.text_color = (text_color != null)?START+text_color.getTextValue()+END:"";
    }
    
    public String getFormattedString(String text){
        return this.bg_color+this.text_color+text+RESET;
    }

    public static class PrinterBuilder{

        private boolean bright;
        private Color bg_color;
        private Color text_color;

        public PrinterBuilder withBackGroundColor(Color color){
            this.bg_color = color;
            return this;
        }
        public PrinterBuilder withTextColor(Color color){
            this.text_color = color;
            return this;
        }
        public PrinterBuilder withBrightness(boolean bright){
            this.bright = bright;
            return this;
        }

        public ColorPrinter build(){
            return new ColorPrinter(this.bright,this.bg_color,this.text_color);
        }
    }
}
