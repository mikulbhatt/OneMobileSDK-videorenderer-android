package com.aol.mobile.sdk.renderer.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.aol.mobile.sdk.renderer.AudioTrack;
import com.aol.mobile.sdk.renderer.TextTrack;

import java.util.List;

public class VideoVM {
    @Nullable
    public AudioTrack selectedAudioTrack;
    @Nullable
    public TextTrack selectedTextTrack;
    @Nullable
    public String videoUrl;
    @Nullable
    public String title;
    @Nullable
    public String subtitleLang;
    @Nullable
    public String subtitleUrl;
    @Nullable
    public Long seekPosition;
    @Nullable
    public Long currentPosition;
    public boolean isScalable = true;
    public boolean isMaintainAspectRatio = true;
    public boolean isMuted;
    public boolean shouldPlay;
    public double longitude;
    public double latitude;
    public boolean isLive;
    @Nullable
    public Callbacks callbacks;

    public interface Callbacks {
        /**
         * Fired when new subtitle need to be shown
         *
         * @param subtitle text of subtitle to show
         */
        void onSubtitleUpdated(@Nullable CharSequence subtitle);

        /**
         * Fired when duration of video is set.
         *
         * @param duration time in milliseconds, may be 0 if duration is not defined (live stream)
         */
        void onDurationReceived(long duration);

        /**
         * Fired when new position of playback reached
         *
         * @param position time in milliseconds
         */
        void onVideoPositionUpdated(long position);

        /**
         * Fired when playback buffer amount changed
         *
         * @param bufferedPercentage value from 0 to 100
         */
        void onVideoBufferUpdated(int bufferedPercentage);

        /**
         * Fired when viewport size changed
         *
         * @param viewWidth  viewport width in pixels
         * @param viewHeight viewport height in pixels
         */
        void onViewportResized(int viewWidth, int viewHeight);

        /**
         * Fired when actual playback flag is changed
         *
         * @param isActuallyPlaying <b>true</b> if video is actually playing, <b>false</b> otherwise
         */
        void onVideoPlaybackFlagUpdated(boolean isActuallyPlaying);

        /**
         * Fired when video reached its end
         */
        void onVideoEnded();

        /**
         * Fired when error encountered during video playback
         *
         * @param error one of {@link Error}
         */
        void onErrorOccurred(@NonNull Error error);

        /**
         * Camera direction angles
         *
         * @param lng longitude
         * @param lat latitude
         */
        void onCameraDirectionChanged(double lng, double lat);

        /**
         * Fired when seek if performed.
         */
        void onSeekPerformed();

        /**
         * Fired when hls bitrate is updated.
         */
        void onHlsBitrateUpdated(long bitrate);

        /**
         * Fired when track configuration has changed
         *
         * @param audioTrackList list of available audio tracks
         * @param textTrackList  list of available cc tracks
         */
        void onTrackInfoAvailable(@NonNull List<AudioTrack> audioTrackList, @NonNull List<TextTrack> textTrackList);

        enum Error {
            /**
             * Bad internet or slow, timed out connection error.
             */
            CONNECTION,
            /**
             * Broken video error.
             */
            CONTENT
        }
    }
}
