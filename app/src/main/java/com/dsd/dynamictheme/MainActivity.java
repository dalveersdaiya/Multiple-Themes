package com.dsd.dynamictheme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSelectTheme;
    private TextView tvSelectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkForTheme(this);
        setContentView(R.layout.activity_main);
        viewByIds();
        applyClickListeners();
        setSelectedTheme(tvSelectedTheme);
    }

    public static void initActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void viewByIds() {
        buttonSelectTheme = findViewById(R.id.button_select_theme);
        tvSelectedTheme = findViewById(R.id.tv_selected_theme);
    }

    public void applyClickListeners() {
        buttonSelectTheme.setOnClickListener(this);
    }


    public void checkForTheme(Context context) {
        try {
            String mySelectedTheme = PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme));
            if (mySelectedTheme.contains(getResources().getString(R.string.default_theme))) {
                setTheme(R.style.MyTheme_Default);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.red))) {
                setTheme(R.style.MyTheme_Red);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.white))) {
                setTheme(R.style.MyTheme_White);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.black))) {
                setTheme(R.style.MyTheme_Black);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.teal))) {
                setTheme(R.style.MyTheme_Teal);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.brown))) {
                setTheme(R.style.MyTheme_Brown);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.cyan))) {
                setTheme(R.style.MyTheme_Cyan);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.pink))) {
                setTheme(R.style.MyTheme_Pink);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.orange))) {
                setTheme(R.style.MyTheme_Orange);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.green))) {
                setTheme(R.style.MyTheme_Green);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.purple))) {
                setTheme(R.style.MyTheme_Purple);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.blue))) {
                setTheme(R.style.MyTheme_Blue);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.yellow))) {
                setTheme(R.style.MyTheme_Yellow);
            } else {
                setTheme(R.style.MyTheme_Default);
            }
        } catch (Exception e) {
            setTheme(R.style.MyTheme_Default);
        }
    }

    public int getAccentColor(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.colorAccent, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    public int getColorPrimary(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    public int getColorPrimaryDark(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    public int getColorMyThemelight(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.my_theme_light, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    /*White*/
    public int getOppositeColor(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.my_text_color_inverse, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    /*Black*/
    public int getTextColor(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.my_text_color, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    public void setSelectedTheme(TextView selected_theme) {
        if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.default_theme))) {
            selected_theme.setText(getResources().getString(R.string.default_theme_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.blue))) {
            selected_theme.setText(getResources().getString(R.string.blue_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.red))) {
            selected_theme.setText(getResources().getString(R.string.red_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.yellow))) {
            selected_theme.setText(getResources().getString(R.string.yellow_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.teal))) {
            selected_theme.setText(getResources().getString(R.string.teal_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.green))) {
            selected_theme.setText(getResources().getString(R.string.green_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.brown))) {
            selected_theme.setText(getResources().getString(R.string.brown_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.purple))) {
            selected_theme.setText(getResources().getString(R.string.purple_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.pink))) {
            selected_theme.setText(getResources().getString(R.string.pink_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.orange))) {
            selected_theme.setText(getResources().getString(R.string.orange_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.cyan))) {
            selected_theme.setText(getResources().getString(R.string.cyan_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.white))) {
            selected_theme.setText(getResources().getString(R.string.white_theme));
        } else if (PreferencesManager.getPreferenceByKey(MainActivity.this, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.black))) {
            selected_theme.setText(getResources().getString(R.string.black_theme));
        } else {
            selected_theme.setText(getResources().getString(R.string.default_theme_theme));
        }
    }

    public void setThemeSelectionDialog(final Context context) {

        final AlertDialog.Builder materialDialog = new AlertDialog.Builder(context);
        materialDialog.setCancelable(true);
        materialDialog.setTitle(getResources().getString(R.string.select_theme));
        final View view = LayoutInflater.from(context).inflate(R.layout.theme_layout, null);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        final RadioButton radio_btn_default = (RadioButton) view.findViewById(R.id.radio_btn_default);
        final RadioButton radio_btn_blue = (RadioButton) view.findViewById(R.id.radio_btn_blue);
        final RadioButton radio_btn_red = (RadioButton) view.findViewById(R.id.radio_btn_red);
        final RadioButton radio_btn_yellow = (RadioButton) view.findViewById(R.id.radio_btn_yellow);
        final RadioButton radio_btn_teal = (RadioButton) view.findViewById(R.id.radio_btn_teal);
        final RadioButton radio_btn_green = (RadioButton) view.findViewById(R.id.radio_btn_green);
        final RadioButton radio_btn_purple = (RadioButton) view.findViewById(R.id.radio_btn_purple);
        final RadioButton radio_btn_pink = (RadioButton) view.findViewById(R.id.radio_btn_pink);
        final RadioButton radio_btn_orange = (RadioButton) view.findViewById(R.id.radio_btn_orange);
        final RadioButton radio_btn_cyan = (RadioButton) view.findViewById(R.id.radio_btn_cyan);
        final RadioButton radio_btn_brown = (RadioButton) view.findViewById(R.id.radio_btn_brown);
        final RadioButton radio_btn_white = (RadioButton) view.findViewById(R.id.radio_btn_white);
        final RadioButton radio_btn_black = (RadioButton) view.findViewById(R.id.radio_btn_black);

        radio_btn_default.setTag(getResources().getString(R.string.default_theme));
        radio_btn_blue.setTag(getResources().getString(R.string.blue));
        radio_btn_red.setTag(getResources().getString(R.string.red));
        radio_btn_yellow.setTag(getResources().getString(R.string.yellow));
        radio_btn_teal.setTag(getResources().getString(R.string.teal));
        radio_btn_green.setTag(getResources().getString(R.string.green));
        radio_btn_brown.setTag(getResources().getString(R.string.brown));
        radio_btn_purple.setTag(getResources().getString(R.string.purple));
        radio_btn_pink.setTag(getResources().getString(R.string.pink));
        radio_btn_orange.setTag(getResources().getString(R.string.orange));
        radio_btn_cyan.setTag(getResources().getString(R.string.cyan));
        radio_btn_white.setTag(getResources().getString(R.string.white));
        radio_btn_black.setTag(getResources().getString(R.string.black));

        if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.default_theme))) {
            radio_btn_default.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.blue))) {
            radio_btn_blue.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.red))) {
            radio_btn_red.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.yellow))) {
            radio_btn_yellow.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.teal))) {
            radio_btn_teal.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.green))) {
            radio_btn_green.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.brown))) {
            radio_btn_brown.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.purple))) {
            radio_btn_purple.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.pink))) {
            radio_btn_pink.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.orange))) {
            radio_btn_orange.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.cyan))) {
            radio_btn_cyan.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.white))) {
            radio_btn_white.setChecked(true);
        } else if (PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).contains(getResources().getString(R.string.black))) {
            radio_btn_black.setChecked(true);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radio_btn_default) {
                    radio_btn_default.setChecked(true);
                } else if (checkedId == R.id.radio_btn_blue) {
                    radio_btn_blue.setChecked(true);
                } else if (checkedId == R.id.radio_btn_red) {
                    radio_btn_red.setChecked(true);
                } else if (checkedId == R.id.radio_btn_yellow) {
                    radio_btn_yellow.setChecked(true);
                } else if (checkedId == R.id.radio_btn_teal) {

                    radio_btn_teal.setChecked(true);
                } else if (checkedId == R.id.radio_btn_green) {

                    radio_btn_green.setChecked(true);
                } else if (checkedId == R.id.radio_btn_brown) {

                    radio_btn_brown.setChecked(true);
                } else if (checkedId == R.id.radio_btn_purple) {

                    radio_btn_purple.setChecked(true);
                } else if (checkedId == R.id.radio_btn_pink) {

                    radio_btn_pink.setChecked(true);
                } else if (checkedId == R.id.radio_btn_orange) {

                    radio_btn_orange.setChecked(true);
                } else if (checkedId == R.id.radio_btn_cyan) {

                    radio_btn_cyan.setChecked(true);
                } else if (checkedId == R.id.radio_btn_white) {

                    radio_btn_white.setChecked(true);
                } else if (checkedId == R.id.radio_btn_black) {

                    radio_btn_black.setChecked(true);
                }
            }
        });
        materialDialog.setView(view);

        materialDialog.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedmemberId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedbutton = (RadioButton) view.findViewById(selectedmemberId);
                if (!PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme)).equals(selectedbutton.getTag().toString())) {
                    if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.default_theme))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.default_theme));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.blue))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.blue));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.red))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.red));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.yellow))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.yellow));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.teal))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.teal));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.green))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.green));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.brown))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.brown));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.purple))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.purple));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.pink))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.pink));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.orange))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.orange));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.cyan))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.cyan));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.white))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.white));
                    } else if (selectedbutton.getTag().toString().equals(getResources().getString(R.string.black))) {
                        PreferencesManager.setPreferenceByKey(context, getResources().getString(R.string.theme), getResources().getString(R.string.black));
                    }
                    PreferencesManager.setPreferenceBooleanByKey(context, "setTheme", true);
//                    recreate();to restart same activity
                    SplashActivity.initActivity(MainActivity.this);
                }
                dialog.dismiss();
            }
        });

        materialDialog.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog dialog = materialDialog.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_select_theme:
                setThemeSelectionDialog(MainActivity.this);
                break;
            default:
                break;

        }
    }
}
