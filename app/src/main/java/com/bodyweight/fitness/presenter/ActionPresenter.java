package com.bodyweight.fitness.presenter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;

import com.bodyweight.fitness.Constants;
import com.bodyweight.fitness.stream.RepositoryStream;
import com.bodyweight.fitness.stream.SetReps;
import com.bodyweight.fitness.stream.Stream;
import com.bodyweight.fitness.view.ActionView;
import com.bodyweight.fitness.view.dialog.LogWorkoutDialog;

import com.bodyweight.fitness.R;
import com.bodyweight.fitness.stream.RoutineStream;
import com.bodyweight.fitness.ui.ProgressActivity;
import com.bodyweight.fitness.view.dialog.ProgressDialog;

import rx.functions.Action1;

public class ActionPresenter extends IPresenter<ActionView> {
    private transient LogWorkoutDialog mLogWorkoutDialog;
    private Integer mId = R.id.action_menu_home;

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mLogWorkoutDialog != null) {
            mLogWorkoutDialog.dismiss();
            mLogWorkoutDialog = null;
        }
    }

    @Override
    public void onSaveInstanceState() {
        super.onSaveInstanceState();

        if (mLogWorkoutDialog != null) {
            mLogWorkoutDialog.dismiss();
            mLogWorkoutDialog = null;
        }
    }

    @Override
    public void onSubscribe() {
        super.onSubscribe();

        if (mId.equals(R.id.action_menu_home)) {
            mView.showActionButtons();
        } else {
            mView.hideActionButtons();
        }

       subscribe(RoutineStream.getInstance()
               .getExerciseObservable()
               .subscribe(exercise -> {
                   if (exercise.hasProgressions()) {
                       mView.setActionButtonImageDrawable(R.drawable.action_progression_white);
                       mView.showActionSheetChooseProgression();
                   } else {
                       mView.setActionButtonImageDrawable(R.drawable.action_add);
                       mView.hideActionSheetChooseProgression();
                   }
               }));

        subscribe(Stream.INSTANCE
                .getDrawerObservable()
                .subscribe(id -> {
                    mId = id;

                    if (id.equals(R.id.action_menu_home)) {
                        mView.showActionButtons();
                    } else {
                        mView.hideActionButtons();
                    }
                }));

        subscribe(Stream.INSTANCE
                .getLoggedSecondsObservable()
                .subscribe(loggedSeconds -> {
                    Snackbar.make(mView, String.format("Logged time %s:%s",
                            formatMinutes(loggedSeconds),
                            formatSeconds(loggedSeconds)
                    ), Snackbar.LENGTH_LONG).show();
                }));

        subscribe(Stream.INSTANCE.getLoggedSetRepsObservable().subscribe(new Action1<SetReps>() {
            @Override
            public void call(SetReps setReps) {
                Snackbar.make(mView, String.format("Logged Set %d with %d Reps", setReps.getSet(), setReps.getReps()), Snackbar.LENGTH_LONG).show();
            }
        }));
    }

    public void onClickLogWorkoutButton() {
        mLogWorkoutDialog = new LogWorkoutDialog(getContext());
        mLogWorkoutDialog.show();
    }

    public void onClickWatchOnYouTube() {
        String id = RoutineStream.getInstance().getExercise().getYouTubeId();

        if(id != null) {
            try {
                getContext().startActivity(
                        new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id))
                );
            } catch(ActivityNotFoundException e) {
                getContext().startActivity(
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id))
                );
            }
        }
    }

    public void onClickChooseProgression() {
        ProgressDialog progressDialog = new ProgressDialog(getContext(), RoutineStream.getInstance().getExercise());
        progressDialog.show();
    }

    public void onClickLogWorkout() {
        String routineId = RepositoryStream.getInstance().getRepositoryRoutineForToday().getId();

        getContext().startActivity(
                new Intent(getContext(), ProgressActivity.class)
                        .putExtra(Constants.INSTANCE.getPRIMARY_KEY_ROUTINE_ID(), routineId)
        );
    }

    public String formatMinutes(int seconds) {
        int minutes = seconds / 60;

        if (minutes == 0) {
            return "00";
        } else if (minutes < 10) {
            return "0" + minutes;
        }

        return String.valueOf(minutes);
    }

    public String formatSeconds(int seconds) {
        int s = seconds % 60;

        if (s == 0) {
            return "00";
        } else if (s < 10) {
            return "0" + s;
        }

        return String.valueOf(s);
    }
}
