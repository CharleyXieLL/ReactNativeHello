import {
  Image,
  ImageSourcePropType,
  StyleProp,
  Text,
  TouchableHighlight,
  View,
  ViewStyle,
} from 'react-native';
import {commonstyle} from '../../../styles/common-style';
import {ImagePathMain} from '../../../utils/ImagePath';
import * as React from 'react';
import {commoncolor} from '../../../styles/common-color';
import {RouterScreen} from '../../../router';

interface MainTabItemProps {
  type: RouterScreen;
  isCheck: boolean;
}

class MainTabItemState {
  icon: ImageSourcePropType = ImagePathMain.image_tab_home_grey;
  text: RouterScreen = RouterScreen.HOME;
}

const MainTabItemView = (props: MainTabItemProps) => {
  const [itemState, setItemState] = React.useState(new MainTabItemState());

  React.useEffect(() => {
    let status: MainTabItemState = new MainTabItemState();
    switch (props.type) {
      case RouterScreen.HOME:
        status.icon = props.isCheck
          ? ImagePathMain.image_tab_home_light
          : ImagePathMain.image_tab_home_grey;
        status.text = RouterScreen.HOME;
        break;
      case RouterScreen.PROFILE:
        status.icon = props.isCheck
          ? ImagePathMain.image_tab_profile_light
          : ImagePathMain.image_tab_profile_grey;
        status.text = RouterScreen.PROFILE;
        break;
      case RouterScreen.MINE:
        status.icon = props.isCheck
          ? ImagePathMain.image_tab_mine_light
          : ImagePathMain.image_tab_mine_grey;
        status.text = RouterScreen.MINE;
        break;
    }
    setItemState(status);
  }, [props.isCheck, props.type]);

  return (
    <View
      style={[commonstyle.flex_v, commonstyle.flex_center, commonstyle.flex_1]}>
      <Image source={itemState.icon} style={[commonstyle.image_wh_tab]} />
      <Text
        style={[
          commonstyle.font_size_body_min,
          commonstyle.font_color_8a8a8a,
          props.isCheck
            ? commonstyle.font_color_main
            : commonstyle.font_color_8a8a8a,
        ]}>
        {itemState.text}
      </Text>
    </View>
  );
};

interface MainTabProps {
  style: StyleProp<ViewStyle> | undefined;
  onClickTab: (page: RouterScreen) => void;
}
const MainTabView = (_props: MainTabProps) => {
  const [mainTabList] = React.useState([
    {type: RouterScreen.HOME, isCheck: true},
    {type: RouterScreen.PROFILE, isCheck: false},
    {type: RouterScreen.MINE, isCheck: false},
  ]);
  const [currentPage, setCurrentPage] = React.useState(RouterScreen.HOME);

  const itemClick = (item: MainTabItemProps, index: number) => {
    if (currentPage === item.type) {
      return;
    }
    setCurrentPage(item.type);
    mainTabList.forEach(value => {
      value.isCheck = false;
    });
    mainTabList[index].isCheck = true;
    _props.onClickTab(item.type);
  };

  const getMainTabListView = mainTabList.map((item, index) => {
    return (
      <TouchableHighlight
        underlayColor={commoncolor.white}
        style={[commonstyle.flex_1]}
        key={item.type}
        onPress={() => itemClick(item, index)}>
        <MainTabItemView type={item.type} isCheck={item.isCheck} />
      </TouchableHighlight>
    );
  });

  return (
    <View
      style={[
        commonstyle.height_main_tab,
        commonstyle.width_100,
        commonstyle.background_white,
        commonstyle.flex_h,
      ]}>
      {getMainTabListView}
    </View>
  );
};

export default MainTabView;
