import {StyleSheet} from 'react-native';
import {commoncolor} from './common-color';

export const commonstyle = StyleSheet.create({
  flex_1: {
    flex: 1,
  },
  flex_h: {
    flexDirection: 'row',
  },
  flex_h_center: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  flex_center: {
    alignItems: 'center',
    justifyContent: 'center',
  },
  flex_v: {
    flexDirection: 'column',
  },
  flex_v_center: {
    flexDirection: 'column',
    alignItems: 'center',
  },
  flex_wrap_wrap: {
    flexWrap: 'wrap',
  },
  flex_space_between: {
    justifyContent: 'space-between',
  },
  margin_top_common: {
    marginTop: 20,
  },
  padding_h_common: {
    paddingHorizontal: 20,
  },
  font_size_24: {
    fontSize: 24,
  },
  font_size_title: {
    fontSize: 18,
  },
  font_size_body: {
    fontSize: 16,
  },
  font_size_body_sm: {
    fontSize: 14,
  },
  font_size_body_min: {
    fontSize: 12,
  },
  font_color_black: {
    color: commoncolor.black,
  },
  font_color_body: {
    color: commoncolor.color_font_body,
  },
  font_color_main: {
    color: commoncolor.main,
  },
  font_color_8a8a8a: {
    color: commoncolor.c_8a8a8a,
  },
  font_weight_400: {
    fontWeight: '400',
  },
  font_weight_600: {
    fontWeight: '600',
  },
  font_weight_700: {
    fontWeight: '700',
  },
  font_weight_bolder: {
    fontWeight: '900',
  },
  background_main: {
    backgroundColor: '#1B518C',
  },
  background_white: {
    backgroundColor: '#FFFFFF',
  },
  background_line: {
    backgroundColor: '#F3F3F3',
  },
  position_absolute: {
    position: 'absolute',
  },
  position_relative: {
    position: 'relative',
  },
  position_top_0: {
    bottom: 0,
  },
  position_right_0: {
    right: 0,
  },
  position_bottom_0: {
    bottom: 0,
  },
  position_left_0: {
    left: 0,
  },
  height_main_title: {
    height: 50,
  },
  height_normal_line: {
    height: 1,
  },
  height_main_tab: {
    height: 50,
  },
  height_100: {
    height: '100%',
  },
  height_android_bar: {
    height: 30,
  },
  width_100: {
    width: '100%',
  },
  wh_base_arrow: {
    width: 50,
    height: '100%',
  },
  image_wh_tab: {
    width: 18,
    height: 18,
  },
  image_wh_base_arrow: {
    width: 22,
    height: 22,
  },
});
