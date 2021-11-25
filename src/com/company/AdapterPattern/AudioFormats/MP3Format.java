package com.company.AdapterPattern.AudioFormats;

public class MP3Format implements IFormat {
    private String formatName = "MP3";
    private String formatCode;

    public MP3Format(WAVFormat wavFormat) {
        formatCode = wavFormat.getFormatCode();
        encode();
    }

    @Override
    public String encode() {
        formatCode += "-6ETI-UIL2-9WAX-XHYO";
        return formatCode;
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

    @Override
    public String getFormatInfo() {
        return formatName;
    }
}
