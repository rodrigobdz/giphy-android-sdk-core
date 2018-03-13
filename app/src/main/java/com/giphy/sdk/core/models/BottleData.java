/*
 * Created by Bogdan Tirca on 5/4/17.
 * Copyright (c) 2017 Giphy Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;

public class BottleData implements Parcelable {
    private String tid;

    public BottleData() {}

    public BottleData(final Parcel in) {
        tid = in.readString();
    }

    public BottleData(String tid) {
        this.tid = tid;
    }

    /**
     * @return tid
     */
    public String getTid() {
        return tid;
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void setTid(String tid) {
        this.tid = tid;
    }

    public static final Creator<BottleData> CREATOR = new Creator<BottleData>() {
        @Override
        public BottleData createFromParcel(Parcel in) {
            return new BottleData(in);
        }

        @Override
        public BottleData[] newArray(int size) {
            return new BottleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tid);
    }
}
