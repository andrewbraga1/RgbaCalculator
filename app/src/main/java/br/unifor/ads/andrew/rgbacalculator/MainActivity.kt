package br.unifor.ads.andrew.rgbacalculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.RadioButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {


    private lateinit var mSeekBar_Red: SeekBar
    private lateinit var mSeekBar_Green: SeekBar
    private lateinit var mSeekBar_Blue: SeekBar
    private lateinit var mSeekBar_Alpha: SeekBar
    private lateinit var mEditText_Red:  EditText
    private lateinit var mEditText_Green: EditText
    private lateinit var mEditText_Blue: EditText
    private lateinit var mEditText_Alpha: EditText
    private lateinit var mEditText_Red_Hex: EditText
    private lateinit var mEditText_Green_Hex: EditText
    private lateinit var mEditText_Blue_Hex: EditText
    private lateinit var mEditText_Alpha_Hex: EditText
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

        //EditText Decimal

        mEditText_Red = findViewById(R.id.main_red_text)
        mEditText_Green = findViewById(R.id.main_green_text)
        mEditText_Blue = findViewById(R.id.main_blue_text)
        mEditText_Alpha = findViewById(R.id.main_alpha_text)

        //EditText Hexadecimal
        mEditText_Red_Hex = findViewById(R.id.main_red_hex_text)
        mEditText_Green_Hex = findViewById(R.id.main_green_hex_text)
        mEditText_Blue_Hex = findViewById(R.id.main_blue_hex_text)
        mEditText_Alpha_Hex = findViewById(R.id.main_alpha_hex_text)

        //View
        mColorPanel = findViewById(R.id.main_view_color)

        //Radiobuttons
        mRadioDecimal = findViewById(R.id.main_decimal_radioButton)
        mRadioHexa = findViewById(R.id.main_hexadecimal_radioButton)

        //All Listener for Edit Decimal
        mEditText_Red.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var value = mEditText_Red.text
                mEditText_Red.text = Editable.Factory.getInstance().newEditable(value)
                var int_value = Integer.parseInt(value.toString())
                mSeekBar_Red.progress = int_value
            }
            false

        }
        mEditText_Green.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var value = mEditText_Green.text
                mEditText_Green.text = Editable.Factory.getInstance().newEditable(value)
                var int_value = Integer.parseInt(value.toString())
                mSeekBar_Green.progress = int_value
            }
            false

        }
        mEditText_Blue.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var value = mEditText_Blue.text
                mEditText_Blue.text = Editable.Factory.getInstance().newEditable(value)
                var int_value = Integer.parseInt(value.toString())
                mSeekBar_Blue.progress = int_value
            }
            false

        }
        mEditText_Alpha.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var value = mEditText_Alpha.text
                mEditText_Alpha.text = Editable.Factory.getInstance().newEditable(value)
                var int_value = Integer.parseInt(value.toString())
                mSeekBar_Alpha.progress = int_value
            }
            false

        }
        //All Listener for Edit HexaDecimal
        mEditText_Red_Hex.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                val value = mEditText_Red_Hex.text
                mEditText_Red_Hex.text = Editable.Factory.getInstance().newEditable(value)
                val int_value = Integer.parseInt(value.toString())
                mSeekBar_Red.progress = int_value
            }
            false

        }
        mEditText_Green_Hex.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                val value = mEditText_Green_Hex.text
                mEditText_Green_Hex.text = Editable.Factory.getInstance().newEditable(value)
                val int_value = Integer.parseInt(value.toString())
                mSeekBar_Green.progress = int_value
            }
            false

        }
        mEditText_Blue_Hex.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                val value = mEditText_Blue_Hex.text
                mEditText_Blue_Hex.text = Editable.Factory.getInstance().newEditable(value)
                val int_value = Integer.parseInt(value.toString())
                mSeekBar_Blue.progress = int_value
            }
            false

        }
        mEditText_Alpha_Hex.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                val value = mEditText_Alpha_Hex.text
                mEditText_Alpha_Hex.text = Editable.Factory.getInstance().newEditable(value)
                val int_value = Integer.parseInt(value.toString())
               mSeekBar_Alpha.progress = int_value
            }
            false

        }
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
                        mEditText_Red.visibility = View.VISIBLE
                        mEditText_Green.visibility = View.VISIBLE
                        mEditText_Blue.visibility = View.VISIBLE
                        mEditText_Alpha.visibility = View.VISIBLE

                        mEditText_Red_Hex.visibility = View.INVISIBLE
                        mEditText_Green_Hex.visibility = View.INVISIBLE
                        mEditText_Blue_Hex.visibility = View.INVISIBLE
                        mEditText_Alpha_Hex.visibility = View.INVISIBLE
                    }
                R.id.main_hexadecimal_radioButton ->
                    if (checked) {
                        mRadioDecimal.isChecked = false
                        mEditText_Red_Hex.setVisibility(View.VISIBLE)
                        mEditText_Green_Hex.setVisibility(View.VISIBLE)
                        mEditText_Blue_Hex.setVisibility(View.VISIBLE)
                        mEditText_Alpha_Hex.setVisibility(View.VISIBLE)

                        mEditText_Red.setVisibility(View.INVISIBLE)
                        mEditText_Green.setVisibility(View.INVISIBLE)
                        mEditText_Blue.setVisibility(View.INVISIBLE)
                        mEditText_Alpha.setVisibility(View.INVISIBLE)
                    }
            }
        }

    }


    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean){

            if (mRadioDecimal.isChecked || mRadioHexa.isChecked) {
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


                mEditText_Red.text = Editable.Factory.getInstance().newEditable(R.toString())
                mEditText_Green.text = Editable.Factory.getInstance().newEditable(G.toString())
                mEditText_Blue.text  = Editable.Factory.getInstance().newEditable(B.toString())
                mEditText_Alpha.text = Editable.Factory.getInstance().newEditable(A.toString())

                mColorPanel.setBackgroundColor(Color.argb(A, R, G, B));

                //show the color value

                mEditText_Red_Hex.text =  Editable.Factory.getInstance().newEditable(String.format("%02x", R))
                mEditText_Green_Hex.text =  Editable.Factory.getInstance().newEditable(String.format("%02x", G))
                mEditText_Blue_Hex.text =  Editable.Factory.getInstance().newEditable(String.format("%02x", B))
                mEditText_Alpha_Hex.text =  Editable.Factory.getInstance().newEditable(String.format("%02x", A))

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
