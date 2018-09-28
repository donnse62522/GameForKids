package test.huylx.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<String> question = new ArrayList<>();
    //List<String> answer = new ArrayList<>();
    ImageView imgV;
    String imgName;
    int imgId;
    Button groupBtnFalse[];
    Button groupBtnTrue[];
    Map<Integer, String> txtCLickedBtnFalse = new HashMap<>();
    int posBtnFalse[];
    int tmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question.add("cat");
        question.add("dog");
        question.add("mome");
        imgV = (ImageView) findViewById(R.id.imgV);

        imgName = question.get(2);
        imgId = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgV.setImageResource(imgId);
        //countDuplicate();

        randonBtnTrue();
        randonBtnFalse();
    }

    //int duplicate;
    public void randonBtnTrue() {
        groupBtnTrue = new Button[imgName.length()];
        final GridLayout gridBtnTrue = (GridLayout) findViewById(R.id.gridBtnTrue);
        for (int i = 0; i < imgName.length(); i++) {
            final Button btnTrue = new Button(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 150;
            params.height = 150;
            btnTrue.setLayoutParams(params);
            gridBtnTrue.addView(btnTrue);
            groupBtnTrue[i] = btnTrue;
            btnTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clicked = (Button) v;
                    String txtClickedBtn = clicked.getText().toString();
                    clicked.setText("");
                    for(int i = 0; i < imgName.length(); i++) {
                        if(groupBtnFalse[posBtnFalse[i]].getText().toString().equals("")) {
                            groupBtnFalse[posBtnFalse[i]].setText(txtClickedBtn);
                            groupBtnFalse[posBtnFalse[i]].setVisibility(View.VISIBLE);
                            groupBtnFalse[posBtnFalse[i]].setEnabled(true);
                            tmp++;
                            break;
                        }
                    }
//                    int posClicked = 0;
//                    if(duplicate != 0) {
//                        for(int i = 0; i < imgName.length(); i++) {
//                            if(groupBtnTrue[i].getText().toString().equals(txtClickedBtn)) {
//                                posClicked = i;
//                                duplicate--;
//                                break;
//                            }
//                        }
//                    } else {
//                        for(int i = 0; i < imgName.length(); i++) {
//                            if(groupBtnTrue[i].getText().toString().equals(txtClickedBtn)) {
//                                posClicked = i;
//                            }
//                        }
//                        countDuplicate();
//                    }

                    //int posBtnFalseF = posCLickedBtnFalse.get(posClicked);
//                    groupBtnFalse[posBtnFalseF].setText(txtClickedBtn);
//                    groupBtnFalse[posBtnFalseF].setVisibility(View.VISIBLE);
//                    groupBtnFalse[posBtnFalseF].setEnabled(true);
                    if(tmp == 4) {
                        
                    }
                }
            });
        }
    }

    public void randonBtnFalse() {
        groupBtnFalse = new Button[9];
        GridLayout gridBtnFalse = (GridLayout) findViewById(R.id.gridBtnFalse);
        for (int i = 0; i < 9; i++) {
            final Button btnFalse = new Button(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 150;
            params.height = 150;
            params.rightMargin = 100;
            params.bottomMargin = 30;
            btnFalse.setLayoutParams(params);
            btnFalse.setVisibility(View.INVISIBLE);
            btnFalse.setEnabled(false);
            gridBtnFalse.addView(btnFalse);
            groupBtnFalse[i] = btnFalse;
            btnFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clicked = (Button) v;
                    String textClickedBtn = clicked.getText().toString();
//                    int posClicked = 0;
//                    for (int i = 0; i < 9; i++) {
//                        if(groupBtnFalse[i].getText().toString().equals(textClickedBtn)) {
//                            posClicked = i;
//                            break;
//                        }
//                    }
                    for (int i = 0; i < imgName.length(); i++) {
                        if (groupBtnTrue[i].getText().toString().equals("")) {
                            groupBtnTrue[i].setText(textClickedBtn);
                            txtCLickedBtnFalse.put(i, textClickedBtn);
                            break;
                        }

                    }
                    clicked.setText("");
                    clicked.setVisibility(View.INVISIBLE);
                    clicked.setEnabled(false);

                    for(int i = 0; i < imgName.length(); i++) {
                        if(groupBtnTrue[i].getText().toString().equals("")) {
                            break;
                        }

                    }
                }
            });
        }

        if (imgName.length() == 3) {
            posBtnFalse = new int[]{0, 5, 6};
            setTextBtn(posBtnFalse, 3);
        } else if (imgName.length() == 4) {
            posBtnFalse = new int[]{1, 3, 7, 5};
            setTextBtn(posBtnFalse, 4);
        } else if (imgName.length() == 5) {
            posBtnFalse = new int[]{0, 2, 6, 8, 4};
            setTextBtn(posBtnFalse, 5);
        } else {
            posBtnFalse = new int[]{0, 3, 1, 4, 2, 5};
            setTextBtn(posBtnFalse, 6);
        }


    }

    public void setTextBtn(int pos[], int length) {
        for (int i = 0; i < length; i++) {
            groupBtnFalse[pos[i]].setText("" + imgName.charAt(i) + "");
            groupBtnFalse[pos[i]].setVisibility(View.VISIBLE);
            groupBtnFalse[pos[i]].setEnabled(true);
        }
    }

//    public void countDuplicate() {
//        for(int i = 0; i < imgName.length(); i++) {
//            for(int j = i + 1; j < imgName.length() - 1; j++) {
//                if (imgName.charAt(i) == imgName.charAt(j)) {
//                    duplicate++;
//                    break;
//                }
//            }
//        }
//    }
}
