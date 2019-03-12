package br.unifor.ads.andrew.rgbacalculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {


    private lateinit var mSeekBar_Red: SeekBar
    private lateinit var mSeekBar_Green: SeekBar
    private lateinit var mSeekBar_Blue: SeekBar
    private lateinit var mSeekBar_Alpha: SeekBar
    private lateinit var mTextView_Red: TextView
    private lateinit var mTextView_Green: TextView
    private lateinit var mTextView_Blue: TextView
    private lateinit var mTextView_Alpha: TextView
    private lateinit var mTextView_Red_Hex: TextView
    private lateinit var mTextView_Green_Hex: TextView
    private lateinit var mTextView_Blue_Hex: TextView
    private lateinit var mTextView_Alpha_Hex: TextView
    private lateinit var mRadioDecimal: RadioButton
    private lateinit var mRadioHexa: RadioButton

    private lateinit var mColorPanel: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Seekbars
        mSeekBar_Red = findViewById(R.id.main_red_seekBar)
        mSeekBar_Green = findViewById(R.id.main_green_seekBar)
        mSeekBar_Blue = findViewById(R.id.main_blue_seekBar)
        mSeekBar_Alpha = findViewById(R.id.main_alpha_seekBar)

        //Textviews Decimal
        mTextView_Red = findViewById(R.id.main_red_text)

        mTextView_Green = findViewById(R.id.main_green_text)
        mTextView_Blue = findViewById(R.id.main_blue_text)
        mTextView_Alpha = findViewById(R.id.main_alpha_text)
        //Textviews Hexadecimal
        mTextView_Red_Hex = findViewById(R.id.main_red_hex_text)
        mTextView_Green_Hex = findViewById(R.id.main_green_hex_text)
        mTextView_Blue_Hex = findViewById(R.id.main_blue_hex_text)
        mTextView_Alpha_Hex = findViewById(R.id.main_alpha_hex_text)

        //View
        mColorPanel = findViewById(R.id.main_view_color)

        //Radiobuttons
        mRadioDecimal = findViewById(R.id.main_decimal_radioButton)
        mRadioHexa = findViewById(R.id.main_hexadecimal_radioButton)

//        mSeekBar_Red.setOnSeekBarChangeListener(this);
//        mSeekBar_Green.setOnSeekBarChangeListener(this);
//        mSeekBar_Blue.setOnSeekBarChangeListener(this);
//        mSeekBar_Alpha.setOnSeekBarChangeListener(this);
    }


    fun onRadioButtonClicked(view: View) {
        mSeekBar_Red.setOnSeekBarChangeListener(this);
        mSeekBar_Green.setOnSeekBarChangeListener(this);
        mSeekBar_Blue.setOnSeekBarChangeListener(this);
        mSeekBar_Alpha.setOnSeekBarChangeListener(this);
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.main_decimal_radioButton ->
                    if (checked) {
                        mRadioHexa.isChecked = false

                                           }
                R.id.main_hexadecimal_radioButton ->
                    if (checked) {
                        mRadioDecimal.isChecked = false
                    }
            }
        }

    }


    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        if( mRadioDecimal.isChecked ||  mRadioHexa.isChecked ) {
            var R = mSeekBar_Red.getProgress()
            var G = mSeekBar_Green.getProgress()
            var B = mSeekBar_Blue.getProgress()
            var A = mSeekBar_Alpha.getProgress()

            val id = seekBar.getId()
            //Get the chnaged value
            if (id == br.unifor.ads.andrew.rgbacalculator.R.id.main_red_seekBar)
                R = progress
            else if (id == br.unifor.ads.andrew.rgbacalculator.R.id.main_green_seekBar)
                G = progress
            else if (id == br.unifor.ads.andrew.rgbacalculator.R.id.main_blue_seekBar)
                B = progress
            else if (id == br.unifor.ads.andrew.rgbacalculator.R.id.main_alpha_seekBar)
                A = progress

            mTextView_Red.text = R.toString()
            mTextView_Green.text = G.toString()
            mTextView_Blue.text = B.toString()
            mTextView_Alpha.text = A.toString()

            mColorPanel.setBackgroundColor(Color.argb(A, R, G, B));

            //show the color value
            mTextView_Red_Hex.text = String.format("%02x", R)
            mTextView_Green_Hex.text = String.format("%02x", G)
            mTextView_Blue_Hex.text = String.format("%02x", B)
            mTextView_Alpha_Hex.text = String.format("%02x", A)
            // mColorPanel.setText("0x"+String.format("%02x", A)+String.format("%02x", R)
            //         +String.format("%02x", G)+String.format("%02x", B));


            //some math so text shows (needs improvement for greys)
            //mColorPanel.setTextColor(Color.argb(0xff,255-R,255-G,255-B));
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }


}
