package mmr.maidmodredo.client.maidmodel;

import mmr.maidmodredo.entity.LittleMaidBaseEntity;

public class ModelMulti_Stef<T extends LittleMaidBaseEntity> extends ModelMulti_Steve<T> {

    public MaidModelRenderer bust;

	public ModelMulti_Stef() {
		super();
	}

	public ModelMulti_Stef(float psize) {
		super(psize);
	}

	public ModelMulti_Stef(float psize, float pyoffset, int pTextureWidth,
			int pTextureHeight) {
		super(psize, pyoffset, 64, 32);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
        bipedCloak = new MaidModelRenderer(this, 0, 0);
		bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, psize);
        bipedEars = new MaidModelRenderer(this, 24, 0);
		bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, psize);

        bipedHead = new MaidModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, psize - 0.2F);
		bipedHead.setRotationPoint(0.0F, 1.35F, 0.0F);
        bipedHeadwear = new MaidModelRenderer(this, 32, 0);
		bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, psize + 0.3F);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL = new MaidModelRenderer(this, 0, 0);
		eyeL.addBox(0.0F, -5F, -4.001F, 4, 4, 0, psize - 0.2F);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeR = new MaidModelRenderer(this, 0, 4);
		eyeR.addBox(-4F, -5F, -4.001F, 4, 4, 0, psize - 0.2F);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);

        bipedBody = new MaidModelRenderer(this, 16, 16);
		bipedBody.addBox(-4.0F, 0.2F, -2.0F, 8, 12, 4, psize - 0.3F);
		bipedBody.setRotationPoint(0.0F, 0.7F, 0.0F);
        bust = new MaidModelRenderer(this, 16, 21);
		bust.addBox(-4F, -2F, -2F, 8, 4, 4, psize/* - 0.3001F*/);
		/*bust.setScale(0.9f, 0.8f, 0.8f);
		bust.setRotationPoint(0.0F, 4.25F, -1.4F).setRotateAngleDeg(50F, 0F, 0F);
		*/
        bipedRightArm = new MaidModelRenderer(this, 40, 16);
		bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, psize - 0.4F);
		bipedRightArm.setRotationPoint(-4.4F, 2.85F, 0.0F);
        bipedLeftArm = new MaidModelRenderer(this, 40, 16);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, psize - 0.4F);
		bipedLeftArm.setRotationPoint(4.4F, 2.85F, 0.0F);

        bipedRightLeg = new MaidModelRenderer(this, 0, 16);
		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, psize - 0.3F);
		bipedRightLeg.setRotationPoint(-1.7F, 12.3F, 0.0F);
        bipedLeftLeg = new MaidModelRenderer(this, 0, 16);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, psize - 0.3F);
		bipedLeftLeg.setRotationPoint(1.7F, 12.3F, 0.0F);
		
		HeadMount.setRotationPoint(0.0F, -4.0F, 0.0F);
		HeadTop.setRotationPoint(0.0F, -12.0F, 0.0F);
        Arms[0] = new MaidModelRenderer(this);
		Arms[0].setRotationPoint(-1.5F, 7.2F, -1F);
        Arms[1] = new MaidModelRenderer(this);
		Arms[1].setRotationPoint(1.5F, 7.2F, -1F);

        bipedTorso = new MaidModelRenderer(this);
        bipedNeck = new MaidModelRenderer(this);
        bipedPelvic = new MaidModelRenderer(this);


        mainFrame = new MaidModelRenderer(this);
		mainFrame.setRotationPoint(0F, pyoffset, 0F);
		mainFrame.addChild(bipedTorso);
		bipedTorso.addChild(bipedNeck);
		bipedTorso.addChild(bipedPelvic);
		bipedTorso.addChild(bipedBody);
		bipedNeck.addChild(bipedHead);
		bipedHead.addChild(bipedHeadwear);
		bipedHead.addChild(bipedEars);
		bipedHead.addChild(HeadMount);
		bipedHead.addChild(HeadTop);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(eyeR);
		bipedNeck.addChild(bipedRightArm);
		bipedNeck.addChild(bipedLeftArm);
		bipedPelvic.addChild(bipedRightLeg);
		bipedPelvic.addChild(bipedLeftLeg);
		bipedRightArm.addChild(Arms[0]);
		bipedLeftArm.addChild(Arms[1]);
		bipedBody.addChild(bust);
		bipedBody.addChild(bipedCloak);
		
		bipedEars.showModel = false;
		bipedCloak.showModel = false;
		
	}

	@Override
	public String getUsingTexture() {
		return "Crafter";
	}

	public void setDefaultPause(T entity, float par1, float par2, float pTicksExisted,
								float pHeadYaw, float pHeadPitch) {
		// 初期姿勢
		bipedBody.setRotationPoint(0.0F, 0.7F, 0.0F);bipedBody.setRotateAngle(0.0F, 0.0F, 0.0F);
		bipedHead.setRotationPoint(0.0F, 1.35F, 0.0F);bipedHead.setRotateAngleDeg(pHeadPitch, pHeadYaw, 0.0F);
		bipedRightArm.setRotationPoint(-4.4F, 2.85F, 0.0F);bipedRightArm.setRotateAngleDeg(0.0F, 0.0F, 10.0F);
		bipedLeftArm.setRotationPoint(4.4F, 2.85F, 0.0F);bipedLeftArm.setRotateAngleDeg(0.0F, 0.0F, -10.0F);
		bipedRightLeg.setRotationPoint(-2.3F, 11.5F, 0.0F);bipedRightLeg.setRotateAngleDeg(0.0F, 0.0F, -2.0F);
		bipedLeftLeg.setRotationPoint(2.3F, 11.5F, 0.0F);bipedLeftLeg.setRotateAngleDeg(0.0F, 0.0F, 2.0F);
		bipedNeck.setRotationPoint(0.0F, 0.0F, 0.0F);bipedNeck.setRotateAngle(0.0F, 0.0F, 0.0F);
		bust.setRotationPoint(0.0F, 4.25F, -1.4F);bust.setRotateAngleDeg(50F, 0F, 0F);
	}

	@Override
	public int showArmorParts(int parts, int index) {
/*		if (index == 0) {
			bust.isRendering = parts == 1;
		} else {
			bust.isRendering = parts == 2;
		}*/
		return super.showArmorParts(parts, index);
	}

}
