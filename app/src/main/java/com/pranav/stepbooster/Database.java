package com.pranav.stepbooster;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicInteger;

public class Database extends SQLiteOpenHelper
{
    private final static String DB_NAME = "steps";
    private final static int DB_VERSION = 2;

    private static Database instance;
    private static final AtomicInteger openCounter = new AtomicInteger();
}
