package com.example.caballep.bbvacompass.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class PermissionHelper {

    private static final String TAG = "PermissionHelper_LOG";

    /**
     * Asks the user to allow a single permission in this application
     * @param activity is the activity where the permission is being called
     * @param permission is the permission requested, example: Manifest.permission.WRITE_EXTERNAL_STORAGE
     */
    public static void askPermission(final Activity activity, String permission) {

        Dexter.withActivity(activity)
                .withPermission(permission)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Log.d(TAG, "onPermissionGranted: ");
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Log.d(TAG, "onPermissionDenied: ");
                    }


                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.d(TAG, "onPermissionRationaleShouldBeShown: ");
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    /**
     * Asks the user to allow a single permission in this application
     * @param activity is the activity where the permission is being called
     * @param permissions are the permissions requested, example: Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
     */
    public static void askPermissions(final Activity activity, String... permissions) {

        Dexter.withActivity(activity)
                .withPermissions(permissions)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Log.d(TAG, "onPermissionsChecked: ");
                        if (report.areAllPermissionsGranted()) {
                            Log.d(TAG, "onPermissionsChecked: All permission were granted.");
                        }

                        for (int i=0;i<report.getDeniedPermissionResponses().size();i++) {
                            Log.d("Permission denied: ", report.getDeniedPermissionResponses().get(i).getPermissionName());
                        }

                        //If permission is permanently denied settings are going to be opened
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            Log.d(TAG, "onPermissionsChecked: Opening settings");
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", activity.getPackageName(), null));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Log.d(TAG, "onPermissionRationaleShouldBeShown: ");
                    }
                }).check();
    }
}
