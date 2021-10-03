package com.richarddewan.daggerhiltdemo.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/*
created by Richard Dewan 19/09/2021
*/

class DatabaseService @Inject constructor(@ApplicationContext context: Context) {
}