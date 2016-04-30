package com.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SchoolExpress implements Parcelable{
	public String compant;
	public static final Parcelable.Creator<SchoolExpress> CREATOR = new Creator<SchoolExpress>(){

		@Override
		public SchoolExpress createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SchoolExpress[] newArray(int size) {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
			

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

}
