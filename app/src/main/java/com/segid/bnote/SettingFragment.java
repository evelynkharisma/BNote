package com.segid.bnote;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;

import java.io.File;
import java.io.FileNotFoundException;


public class SettingFragment extends Fragment{

    private ImageView imageView;
    private EditText editText;
    private ImageButton btnEdit;

    private Uri orgUri;

    private ImageChooserManager imageChooserManager;
    private int chooserType;

    String filePath;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        imageView = (ImageView) view.findViewById(R.id.profile_picture);
        editText = (EditText) view.findViewById(R.id.change_name);
        btnEdit = (ImageButton) view.findViewById(R.id.edit_button);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chooseImage();
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


        return view;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == getActivity().RESULT_OK)
        {
            imageView.setImageBitmap(null);
            //Uri return from external activity
            orgUri = data.getData();
            try
            {
                Bitmap bm = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(orgUri));
                imageView.setImageBitmap(bm);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }


    /*private void chooseImage() {
        chooserType = ChooserType.REQUEST_PICK_PICTURE;
        imageChooserManager = new ImageChooserManager(this,
                ChooserType.REQUEST_PICK_PICTURE, true);
        imageChooserManager.setImageChooserListener(this);
        imageChooserManager.clearOldFiles();
        try {
            filePath = imageChooserManager.choose();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onImageChosen(final ChosenImage image) {
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (image != null) {
                    Log.i("NotesList", "Chosen Image: O - " + image.getFilePathOriginal());
                    Intent i = new Intent(getActivity(), ImagePickerActivity.class);
                    i.putExtra("imagePath", image.getFilePathOriginal());
                    startActivityForResult(i, 8221);
                } else {
                    Log.i("NotesList", "Chosen Image: Is null");
                }
            }
        });
    }

    @Override
    public void onError(final String reason) {
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Log.i("NotesList", "OnError: " + reason);
                Toast.makeText(getActivity(), reason,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void reinitializeImageChooser() {
        imageChooserManager = new ImageChooserManager(this, chooserType, true);
        imageChooserManager.setImageChooserListener(this);
        imageChooserManager.reinitialize(filePath);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == getActivity().RESULT_OK
                && (requestCode == ChooserType.REQUEST_PICK_PICTURE)) {
            if (imageChooserManager == null) {
                reinitializeImageChooser();
            }
            imageChooserManager.submit(requestCode, data);
            Log.i("NotesList", "OnActivityResult");
            Log.i("NotesList", "File Path : " + filePath);
            Log.i("NotesList", "Chooser Type: " + chooserType);
        }else if(resultCode == getActivity().RESULT_OK && (requestCode == 8221)){
            filePath = data.getStringExtra("imagePath");
            Log.d("elsa returned", filePath);
        }
    }*/
}