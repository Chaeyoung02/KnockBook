package com.book.common;

import com.book.member.book.dao.BookTextDao;

public class DeleteOldPostsTask implements Runnable {

    @Override
    public void run() {
        new BookTextDao().deleteOldSaveBooktexts();
    }
}