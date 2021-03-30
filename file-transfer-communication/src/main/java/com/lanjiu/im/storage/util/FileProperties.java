package com.lanjiu.im.storage.util;

public class FileProperties {
    private int fragmentCount;
    private long fileLength;
    private int readCount;
    private String serverFileName = "";
    private String clientFileName = "";
    private long position = 0;
    private long writeLength = 0;

    public long getWriteLength() {
        return writeLength;
    }

    public void setWriteLength(long writeLength) {
        this.writeLength = writeLength;
    }

    public int getFragmentCount() {
        return fragmentCount;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public void setFragmentCount(int fragmentCount) {
        this.fragmentCount = fragmentCount;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getServerFileName() { return serverFileName; }

    public void setServerFileName(String serverFileName) { this.serverFileName = serverFileName; }

    public String getClientFileName() { return clientFileName; }

    public void setClientFileName(String clientFileName) { this.clientFileName = clientFileName; }
}
