package cjl.com.motionlayoutdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import kotlinx.android.synthetic.main.activity_second.*

/**
 *@author: cjl
 *@date: 2021/1/10 0010 14
 *@desc:
 */
class SecondActivity :AppCompatActivity(){

    companion object{
        fun launch(context:Context){
            val intent = Intent(context,SecondActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bt1.setOnClickListener {
            //1.通过 getConstraintSet(id:Int) 方法获取转场结束时的ConstraintSet 的对象
            val constraintSet=ml.getConstraintSet(R.id.end)
            //2.getConstraint(id:Int) 获取 ConstraintSet的一个约束对象Constraint
            constraintSet.getConstraint(R.id.box).apply {
                //3.改变约束条件，达到想要的效果
                layout.topToTop=Constraints.LayoutParams.PARENT_ID;
                layout.bottomToBottom=Constraints.LayoutParams.PARENT_ID;
                layout.endToEnd=Constraints.LayoutParams.PARENT_ID;
                transform.rotationY = 180f
                transform.rotationX = 0f
                propertySet.alpha = 0.1f
            }
        }

        bt2.setOnClickListener{
            val constraintSet=ml.getConstraintSet(R.id.end)
            constraintSet.getConstraint(R.id.box).apply {
                layout.topToTop=Constraints.LayoutParams.PARENT_ID;
                layout.endToEnd=Constraints.LayoutParams.PARENT_ID;
                layout.bottomToBottom=Constraints.LayoutParams.UNSET
                transform.rotationY = 0f
                transform.rotationX = 180f
                propertySet.alpha = 0.2f
            }
        }
    }
}