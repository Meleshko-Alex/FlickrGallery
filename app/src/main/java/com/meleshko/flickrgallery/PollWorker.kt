package com.meleshko.flickrgallery

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class PollWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        return Result.success()
    }
}