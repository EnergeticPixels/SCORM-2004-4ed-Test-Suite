## Phase 0 Acceptance Criteria (v1)

Status: Approved
Version: 1.2
Last Updated: 2026-08-26
Scope: Phase 0 only
Source roadmap: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)
Source backlog: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md)

### Purpose
Define objective pass/fail criteria for completing Phase 0 so Phase 1 can begin with clear technical and governance guardrails.

### Mandatory Acceptance Criteria

1. Scope and Strategy Baseline is approved
- Dual-mode strategy is explicitly documented: legacy archival lane plus modern maintained lane.
- Java target is documented as OpenJDK 21 LTS for modern lane (not Oracle JDK by default).
- Distribution vendor and exact runtime version policy are documented (for example: Eclipse Temurin 21.x or Amazon Corretto 21.x).
- Browser policy is documented as evergreen current-2.
- Build migration policy is documented as Ant-first, with future migration optional.
- Evidence: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)

1. Phase 0 backlog is concrete and execution-ready
- A sprint backlog exists with item IDs, estimates, owners, and dependencies.
- Backlog includes a Definition of Done and open-input blockers.
- Evidence: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md)

1. Ownership model is finalized for this project
- All owner placeholders are replaced.
- Owner-role mapping is consistent in planning docs.
- Evidence: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md), [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md), [roles_andWhyPeopleSelected.md](roles_andWhyPeopleSelected.md)

1. Phase 1 is decomposed and linked to Phase 0 outcomes
- Phase 1 backlog exists with concrete items, estimates, and owner assignments.
- Phase 1 includes issue-template guidance for rapid issue creation.
- Evidence: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)

1. Tracking system guidance is documented
- GitHub Projects field model is documented for Phase 0 and Phase 1.
- Required project fields and suggested views are listed.
- Evidence: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md), [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)

1. Operational environment assumptions are documented and approved
- Client-only runtime assumptions are explicit for current scope.
- Browser support policy and offline requirement are explicit.
- Installation and logging assumptions are documented with validation notes for Phase 1.
- Evidence: [phase0_operational_environment_assumptions_v1.md](phase0_operational_environment_assumptions_v1.md)

1. Phase 0 closure process is documented
- Closure checklist exists with status markers and final sign-off block.
- Evidence: [phase0_closure_checklist.md](phase0_closure_checklist.md)

### Completion Evidence for Final Phase 0 Criteria

1. Risk register and governance cadence operational
- Evidence: [phase0_risk_register_and_governance_v1.md](phase0_risk_register_and_governance_v1.md)

1. Quality, accessibility, and security guardrails published and adopted
- Evidence: [phase0_quality_accessibility_security_guardrails_v1.md](phase0_quality_accessibility_security_guardrails_v1.md)

### Approval Checklist

1. PM review complete
- Reviewer: Chrisjen Avasarala
- Date: 2026-08-26
- Decision: Approve

1. TL review complete
- Reviewer: Josephus Miller
- Date: 2026-08-26
- Decision: Approve

1. SME review complete
- Reviewer: Praxidike Meng
- Date: 2026-08-26
- Decision: Approve

### Version History
- v1.0 (2026-08-26): Initial formal acceptance criteria draft for Phase 0.
- v1.1 (2026-08-26): Added operational environment assumptions criterion and evidence link.
- v1.2 (2026-08-26): Marked document approved and linked completion evidence for final Phase 0 criteria.
