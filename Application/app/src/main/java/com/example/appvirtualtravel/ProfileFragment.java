package com.example.appvirtualtravel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.example.appvirtualtravel.R;

import java.util.concurrent.Executor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ProfileFragment extends Fragment {
    TextView profileFullname;
    EditText mFullName, mEmail, mPassword, mPhone, mGender;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nonnull ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container,false);

        profileFullname = view.findViewById(R.id.profile_fullname);
        mFullName = view.findViewById(R.id.fullnamefromDB);
        mEmail = view.findViewById(R.id.emailfromDB);
        mPassword = view.findViewById(R.id.passwordfromDB);
        mPhone = view.findViewById(R.id.phonefromDB);
        mGender = view.findViewById(R.id.gemderfromDB);

        Bundle profileFrag2 = getArguments();
        String fullname = profileFrag2.getString("fullname");
        String email = profileFrag2.getString("email");
        String password = profileFrag2.getString("password");
        String phone = profileFrag2.getString("phone");
        String gender = profileFrag2.getString("gender");

        profileFullname.setText(fullname);
        mFullName.setText(fullname);
        mEmail.setText(email);
        mPassword.setText(password);
        mPhone.setText(phone);
        mGender.setText(gender);

        return view;
    }
}
