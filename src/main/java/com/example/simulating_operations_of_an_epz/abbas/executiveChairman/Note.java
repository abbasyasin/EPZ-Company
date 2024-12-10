package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {
    private String title;
    private String content;
    private String category;
    private LocalDate date;
    private File attachment;

    public Note(String title, String content, String category, LocalDate date, File attachment) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.attachment = attachment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentName() {
        return attachment != null ? attachment.getName() : null;
    }
}
