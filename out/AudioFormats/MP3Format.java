package com.company.AudioFormats;

public class MP3Format implements IFormat{
    private String formatName = "MP3";
    private String formatCode = "6ETI-UIL2-9WAX-XHYO";
    private WAVFormat wavFormat;

    public MP3Format(WAVFormat wavFormat) {
        this.wavFormat = wavFormat;
    }

    @Override
    public String encode() {
        return wavFormat.getFormatCode() + "-" + this.formatCode;
    }

    public String getFormatName() {
        return formatName;
    }
    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
    public String getFormatCode() {
        return formatCode;
    }

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }
}
